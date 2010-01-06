require oprofile.inc

PR = "${INC_PR}.0"

SRC_URI += "\
	file://opjitconv-execvp-fix.diff;patch=1 \
	file://0.9.4-armv7a.diff;patch=1 \
	"

