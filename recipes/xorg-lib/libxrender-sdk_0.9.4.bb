require libxrender_${PV}.bb

DEPENDS = "xproto-sdk renderproto-sdk util-macros-sdk libx11-sdk"

inherit sdk

SRC_URI[archive.md5sum] = "dc266e850c51368f964e0d67bf5fb5e6"
SRC_URI[archive.sha256sum] = "5682d343dd4e7ef291a6577e956c331946ce5801d8fa076284a01b41de3017ec"
