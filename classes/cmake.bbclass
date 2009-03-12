DEPENDS += " cmake-native "

# We want the staging and installing functions from autotools
inherit autotools

OECMAKE_SOURCEPATH ?= "."

cmake_do_configure() {
     cmake ${OECMAKE_SOURCEPATH} \
     -DCMAKE_INSTALL_PREFIX:PATH=${prefix} -Wno-dev \
     -DCMAKE_FIND_ROOT_PATH=${STAGING_DIR_HOST} \
     ${EXTRA_OECMAKE}
}

EXPORT_FUNCTIONS do_configure
