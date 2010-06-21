require apt-native.inc
PR = "r2"

SRC_URI += "file://nodoc.patch \
            file://noconfigure.patch \
	    file://no-curl.patch \
	    file://fix-gcc-4.4-compile.patch"

SRC_URI[md5sum] = "e6ee1b594f6ed5fab5cb593ee46cfc21"
SRC_URI[sha256sum] = "4dc935a520c65705795ada5942b658f6e86b22eefc7032342267272bd6566b05"
