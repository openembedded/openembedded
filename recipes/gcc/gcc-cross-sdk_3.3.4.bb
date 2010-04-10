PR = "${INC_PR}.1"

inherit sdk

require gcc-${PV}.inc
require gcc-cross-sdk.inc
require gcc-configure-sdk.inc
require gcc-package-sdk.inc

SRC_URI += 'file://sdk-libstdc++-includes.patch;patch=1'

SRC_URI[md5sum] = "a1c267b34f05c8660b24251865614d8b"
SRC_URI[sha256sum] = "3f409186acee739641341e5486e30ea9acecc039452e97a9eb850afbc6c3a691"
