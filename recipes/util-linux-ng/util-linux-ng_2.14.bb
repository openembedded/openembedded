require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://util-linux-ng-uclibc-versionsort.patch;patch=1 \
	    file://util-linux-ng-replace-siginterrupt.patch;patch=1 \
	   "

SRC_URI[archive.md5sum] = "23f227da49df36f33fe47e917e332cd8"
SRC_URI[archive.sha256sum] = "7736d8d7d3b39654e350416585b3e00af9f55670cce8b3dddd2c2494cbaae81c"
