LICENSE = "GPL"
SECTION = "unknown"
DESCRIPTION = "Regex-markup performs regular expression-based text \
markup according to used-defined rules."


SRC_URI = "http://www.student.lu.se/~nbi98oli/src/regex-markup-${PV}.tar.gz \
	   file://fix-configure.patch;patch=1"

inherit autotools
