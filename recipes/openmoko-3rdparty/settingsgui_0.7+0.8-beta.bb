DESCRIPTION = "Openmoko Settings GUI"
AUTHOR = "Kristian M."
SECTION = "openmoko/applications"
RDEPENDS = "python-pygtk python-subprocess python-threading"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://mput.de/~kristian/.openmoko/settingsgui-0.8-beta.tar.bz2"
S = "${WORKDIR}/settingsgui-0.8-beta"

inherit distutils

SRC_URI[md5sum] = "4a4c4855447f506078dfb762ba72e35d"
SRC_URI[sha256sum] = "5f4f727cbe982db701dcc4a70cd2c19a4c153a4b0b35a6b5b561b48d53649855"
