require oprofile.inc

PR = "${INC_PR}.0"

SRC_URI += "\
	file://opjitconv-execvp-fix.diff;patch=1 \
	file://0.9.4-armv7a.diff;patch=1 \
	"


SRC_URI[tarball.md5sum] = "82b059379895cf125261d7d773465915"
SRC_URI[tarball.sha256sum] = "cb1452159036ba7d3003b75dfef38fcbc61503f76adfca2879ebf7766931cade"
