DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "virtual/evas virtual/ecore eet embryo edje-native virtual/imlib2"
LICENSE = "MIT"
PR = "r1"

inherit efl

LEAD_SONAME = "libedje.so"

FILES_${PN}-dev += "${bindir}"

RDEPENDS_${PN}-dev += "cpp"