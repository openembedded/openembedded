require libfontenc_${PV}.bb

DEPENDS = "zlib-native xproto-native"
PE = "1"

XORG_PN = "libfontenc"

inherit native

SRC_URI[archive.md5sum] = "4f0d8191819be9f2bdf9dad49a65e43b"
SRC_URI[archive.sha256sum] = "7f3cde0331e9ad3da720b1a8255e121673701199df0802b62380436e74222700"
