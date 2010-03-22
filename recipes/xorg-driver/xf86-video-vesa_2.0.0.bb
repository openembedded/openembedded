require xorg-driver-video.inc
PE = "1"

SRC_URI += "file://fix-includepath.patch;patch=1 \
            file://fix-configure-includes.patch;patch=1"

#DESCRIPTION = ""

#DEPENDS += " "
SRC_URI[archive.md5sum] = "433cf6f961eb4a2ab6fcb086def0b2b4"
SRC_URI[archive.sha256sum] = "f20b2e429657552eea207fb8bc4b47c8e293d99c229dcb4da11b7c5bfdc1e165"
