require util-linux-ng.inc

PR = "${INC_PR}"

SRC_URI += "file://uclibc-compile.patch \
            file://tls.patch \
	    file://util-linux-ng-replace-siginterrupt.patch \
           "

SRC_URI[archive.md5sum] = "9623380641b0c2e0449f5b1ecc567663"
SRC_URI[archive.sha256sum] = "a6365fcb2b34439faa52164e1a018086c2b6818f8a189c487c79e09dc3c62722"
