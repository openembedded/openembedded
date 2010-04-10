require libxcursor_${PV}.bb

DEPENDS = "libx11-native fixesproto-native libxfixes-native"
PE = "1"

inherit native

SRC_URI[archive.md5sum] = "99b7554037a92b260891091e81815a0a"
SRC_URI[archive.sha256sum] = "1dffb3542271c8ce964066d561474caec5b639d6588b257b21cfb8225a15d2b4"
