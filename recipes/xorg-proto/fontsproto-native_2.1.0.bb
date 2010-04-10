require fontsproto_${PV}.bb

PR = "r1"

XORG_PN = "fontsproto"

S = "${WORKDIR}/fontsproto-${PV}"

inherit native

SRC_URI[archive.md5sum] = "f3a857deadca3144fba041af1dbf7603"
SRC_URI[archive.sha256sum] = "5a9af61dc9142488c9ba6e4ae30a9d970ea0f889a1ab7f59de1c1898c83aeb35"
