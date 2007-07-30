inherit autotools pkgconfig

HOMEPAGE = "http://www.openmoko.org"
OPENMOKO_RELEASE ?= "OM-2007.2"
OPENMOKO_MIRROR ?= "svn://svn.openmoko.org/trunk"

def openmoko_two_get_license(d):
    import bb
    openmoko, section = bb.data.getVar('SECTION', d, 1).split("/")
    return "LGPL GPL".split()[section != "libs"]

def openmoko_two_get_subdir(d):
    import bb
    openmoko, section = bb.data.getVar('SECTION', d, 1).split("/")
    if section == 'base': return ""
    elif section == 'libs': return "libraries"
    elif section in 'apps tools pim'.split(): return "applications"
    elif section == "panel-plugin": return "panel-plugins"
    elif section == "inputmethods": return "inputmethods"
    else: return section

def openmoko_strip_two(d):
    import bb
    pname, openmokonumber = bb.data.getVar('PN', d, 1).split("2")
    return pname


LICENSE = "${@openmoko_two_get_license(d)}"
SUBDIR = "${@openmoko_two_get_subdir(d)}"
PNAME = "${@openmoko_strip_two(d)}"

SRC_URI := "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/${SUBDIR};module=${PNAME};proto=http"
S = "${WORKDIR}/${PNAME}"

FILES_${PN} += "${datadir}/icons"
