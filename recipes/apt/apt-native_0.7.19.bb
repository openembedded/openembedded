require apt-native.inc
PR = "r3"

SRC_URI += "file://nodoc.patch \
            file://noconfigure.patch \
	    file://no-curl.patch"

SRC_URI[md5sum] = "0ef50176aea36cb0cce633a9b62dc7eb"
SRC_URI[sha256sum] = "c928f5eb2baffb50e7ccf02d07a16daf867945c8aa542d500bbbbaff7bbcef42"
