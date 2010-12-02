require bug-app.inc

DESCRIPTION = "After I took a couple of courses in Theoretical Computer Science, I started to like regular expression.  When I realized that the package   was not available on the bug platform, I loved the idea of creating my own regexp bundle. \
This bundle uses 'dk.brics.automaton(c)':http://www.brics.dk/~amoeller/automaton/index.html developed by Anders Moeller. \
To uses the package just export _*com.buglabs.common.regexp.pub*_  in your manifest file.  Also Take a look at 'RegExpSample':http://buglabs.net/applications/RegExpSample to see how to use this package. Download both this application and RegExpSample to Dragonfly or your BUG.\
Regular expressions basic syntax:\
UNION\
unionexp ::= interexp | unionexp  (union)	\
interexp ::= concatexp & interexp (intersection) [OPTIONAL]\
CONCAT\
concatexp ::= repeatexp concatexp (concatenation)	\
REPEAT\
repeatexp ::= repeatexp ?	(zero or one occurrence)	\
 | repeatexp *	(zero or more occurrences)	\
 | repeatexp +	(one or more occurrences)	\
 | repeatexp {n} (n occurrences)	\
 | repeatexp {n,} (n or more occurrences)	\
 | repeatexp {n,m} (n to m occurrences, including both)	\
 | complexp		\
"
HOMEPAGE = "http://buglabs.net/applications/com.buglabs.common.regexp"

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/850"

APIVERSION = ""
