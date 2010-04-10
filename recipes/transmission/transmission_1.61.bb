require transmission.inc

SRC_URI_append = " file://webupload.patch;patch=1;pnum=0"

PR = "r5"


SRC_URI[archive.md5sum] = "0b0428f4a6237a64dc8b7d378ace3f06"
SRC_URI[archive.sha256sum] = "3bc5bf49ed02a3d93b4b9b71c7814960e972c1bde4e9fb83b2cd500c83ae4a9a"
