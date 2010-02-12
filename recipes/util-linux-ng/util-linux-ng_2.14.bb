require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://util-linux-ng-uclibc-versionsort.patch;patch=1 \
	    file://util-linux-ng-replace-siginterrupt.patch;patch=1 \
	   "
