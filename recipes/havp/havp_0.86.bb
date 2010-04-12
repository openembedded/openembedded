require havp.inc

PR = "r1"

SRC_URI_append += " file://reconfigure.patch;patch=1"

SRC_URI[md5sum] = "c99c8da224c72844882623086e2b1618"
SRC_URI[sha256sum] = "1649ab227c7fd7b4af5ab602a3cdff16c038965c6673c09a239d5df35fa88da8"
