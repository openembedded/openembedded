require pixman.inc
PR = "${INC_PR}.0"

SRC_URI += " \
           file://pixman-arm.patch;patch=1 \
	   file://pixman-x888-565.patch;patch=1 \
	  "

SRC_URI[archive.md5sum] = "09357cc74975b01714e00c5899ea1881"
SRC_URI[archive.sha256sum] = "2b16516ef147bb604e1cf50c883143a052a7ff92d2930b70e571da0603b7d9ce"
