LICENSE = "LGPL"
DEPENDS = "gupnp"

SRC_URI = "http://gupnp.org/sources/${PN}/${PN}-${PV}.tar.gz"

inherit autotools_stage pkgconfig

SRC_URI[md5sum] = "f6e813591ff89e8e61a46f416046450f"
SRC_URI[sha256sum] = "34b6e104b480e501e430daa68fca63906a939a6cb02bc43814ed06d2856a72ac"
