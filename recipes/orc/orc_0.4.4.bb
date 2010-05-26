require orc.inc

PR = "r0"

SRC_URI[orc.md5sum] = "35f3b7283f391ab8ade7f94332940414"
SRC_URI[orc.sha256sum] = "62f8808d61a275861c8e0429c76932ef923f0ca50db8dc3e73b0745a631e386f"

SRC_URI += "file://044_orcutils.patch "
