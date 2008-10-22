DESCRIPTION = "Openmoko Settings GUI"
AUTHOR = "Kristian M."
SECTION = "openmoko/applications"
RDEPENDS = "python-pygtk python-subprocess python-threading"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://mput.de/~kristian/.openmoko/settingsgui-0.8-beta.tar.bz2"
S = "${WORKDIR}/settingsgui-0.8-beta"

inherit distutils
