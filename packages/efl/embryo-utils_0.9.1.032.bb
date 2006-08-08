DESCRIPTION = "Embryo implements a C like scripting language used in various parts \
of the Enlightenment project, namely Edje. Embryo's scripting language is based on \
CompuPhase's Small language that was introduced in Dr Dobb's Journal in 1999. \
Embryo allows scripting capabilities in places that otherwise wouldn't support \
basic programming structures such as in Edje EDCs."
LICENSE = "MIT"
PR = "r4"

inherit efl

SRC_URI = "${E_URI}/embryo-${PV}.tar.gz"
S = "${WORKDIR}/embryo-${PV}"

PACKAGES = "embryo-utils"
FILES_${PN} = "${bindir}/embryo ${bindir}/embryo_* ${datadir}/embryo/include"

libraries = ""
headers = ""
