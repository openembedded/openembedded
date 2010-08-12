require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "6b8a34b274c6fceaffe57c579db826b9"
SRC_URI[archive.sha256sum] = "b8efe0e75ca4ce3a56c9143e360c4f5b20750f4275e8fffbc015ed5e3a17c96a"

BBCLASSEXTEND = "native nativesdk sdk"
