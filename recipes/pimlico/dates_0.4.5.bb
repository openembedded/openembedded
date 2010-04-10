require dates.inc

PR ="r2"

SRC_URI = "http://pimlico-project.org/sources/dates/dates-${PV}.tar.gz \
	   file://dates-owl-window-menu.patch;patch=1 \
	  "

SRC_URI[md5sum] = "13f2bb562a13610c005a4e6204112661"
SRC_URI[sha256sum] = "3febeb76d5b3bf9ef978e1141987b5aa7f064b1a41bf428b9d7b2bcb0782753a"
