require libxkbfile_${PV}.bb

DEPENDS = "libx11-native kbproto-native"
PE = "1"

XORG_PN = "libxkbfile"

inherit native

SRC_URI[archive.md5sum] = "0726a845fe5a56551de2718c9f6b0e35"
SRC_URI[archive.sha256sum] = "0ab628271fc9cb6d05f861d9823573088d81d510aca95b87ac0504b2e558965f"
