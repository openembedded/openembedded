require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "700f8663c23713c2a81a6038a7d358f0"
SRC_URI[archive.sha256sum] = "47b14f6da8c57a726ef1cfa5964a4a6cf9505bc6d78f69d3ae89f4b19956fc2a"

BBCLASSEXTEND = "native nativesdk sdk"
