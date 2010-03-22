require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://uclibc-compile.patch;patch=1 \
            file://tls.patch;patch=1 \
	    file://util-linux-ng-replace-siginterrupt.patch;patch=1 \
           "
