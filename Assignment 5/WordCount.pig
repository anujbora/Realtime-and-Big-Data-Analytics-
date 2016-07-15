/* Load the Input file and clean it */

inputText = LOAD 'input.txt';

cleanInput1 = FOREACH inputText GENERATE REPLACE($0,'-',' ');
cleanInput2 = FOREACH cleanInput1 GENERATE REPLACE($0,',',' ');
cleanInput3 = FOREACH cleanInput2 GENERATE REPLACE($0,':',' ');
cleanInput4 = FOREACH cleanInput3 GENERATE LOWER((chararray)$0);

cleanInput = FOREACH cleanInput4 GENERATE FLATTEN(TOKENIZE($0)) as words;

/* Load the file containing search terms and convert all words to lowercase*/

inputWords = LOAD 'search.txt';

cleanInputWords = FOREACH inputWords GENERATE LOWER((chararray)$0);

/* Match the two data files by JOIN */

match = JOIN cleanInputWords BY $0 LEFT OUTER, cleanInput BY $0;
WordCounts = FOREACH match GENERATE $0,($1 is null ? 0:1);

/* Count Occurences */

GroupWordCounts = GROUP WordCounts BY $0;
FinalCount = FOREACH GroupWordCounts GENERATE group, SUM(WordCounts.$1);

/* Dump the Output */

dump FinalCount;