require apt-native.inc
PR = "r4"

SRC_URI += "file://nodoc.patch;patch=1 \
            file://noconfigure.patch;patch=1"

SRC_URI[md5sum] = "c66f943203fa24e85ed8c48f6ac5ad1e"
SRC_URI[sha256sum] = "e7d58e2b202713b4df8cd5fd58bc20ba8d31c0da6e5e3b3c89a138dbf0b24ad9"
