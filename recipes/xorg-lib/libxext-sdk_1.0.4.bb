require libxext_${PV}.bb

DEPENDS = "xproto-sdk util-macros-sdk libx11-sdk libxau-sdk xextproto-sdk"
PROVIDES = ""

inherit sdk

SRC_URI[archive.md5sum] = "a91f1f722ac80c597cf0b75dcb8b48c0"
SRC_URI[archive.sha256sum] = "2dfd8eace1cafacc87b4055c57efeb771a740e24141d3f113de58c2a9eebd21f"
