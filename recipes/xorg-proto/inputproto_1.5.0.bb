require xorg-proto-common.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI[archive.md5sum] = "dcc36554aea1338b3813943daf1e9988"
SRC_URI[archive.sha256sum] = "ef90f7e4c151095cc75a573acd86355aa65c5bc7fd1dcce4a1483b64788e1461"

BBCLASSEXTEND = "native nativesdk sdk"
