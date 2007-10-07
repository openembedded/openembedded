DESCRIPTION = "Edje is a complex graphical design & layout library."
# can also install vim data files
DEPENDS = "eet evas ecore embryo edje-native"
LICENSE = "MIT"
PV = "0.5.0.41+cvs${SRCDATE}"
PR = "r0"

inherit efl_library

# NOTE: Packaging needs work. edje_cc should actually be in the -dev package etc.

