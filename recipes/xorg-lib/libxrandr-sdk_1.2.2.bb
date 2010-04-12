require libxrandr_${PV}.bb

DEPENDS = "randrproto-sdk util-macros-sdk libxext-sdk libxrender-sdk"

inherit sdk

SRC_URI[archive.md5sum] = "1b244b5d19f0ccab01d7083436cd3558"
SRC_URI[archive.sha256sum] = "206f8dc850f12b1213fb73dbef09fafa1bb8fb8c3ddfe4d39721c1e2dec12a98"
