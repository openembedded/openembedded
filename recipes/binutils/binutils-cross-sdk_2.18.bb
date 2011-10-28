require binutils_${PV}.bb
require binutils-cross-sdk.inc
PR = "${INC_PR}.1"

# Old and wrong now
#SRC_URI[md5sum] = "9d22ee4dafa3a194457caf4706f9cf01"
#SRC_URI[sha256sum] = "487a33a452f0edcf1f8bb8fc23dff5c7a82edec3f3f8b65632b6c945e961ee9b"

# New (since almost 28-OCT-2011)
SRC_URI[md5sum] = "ccd264a5fa9ed992a21427c69cba91d3"
SRC_URI[sha256sum] = "4515254f55ec3d8c4d91e7633f3850ff28f60652b2d90dc88eef47c74c194bc9"
