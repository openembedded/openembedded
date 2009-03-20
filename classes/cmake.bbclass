DEPENDS += " cmake-native "

# We want the staging and installing functions from autotools
inherit autotools

# Use in-tree builds by default but allow this to be changed
# since some packages do not support them (e.g. llvm 2.5).
OECMAKE_SOURCEPATH ?= "."

# If declaring this, make sure you also set EXTRA_OEMAKE to
# "-C ${OECMAKE_BUILDPATH}". So it will run the right makefiles.
OECMAKE_BUILDPATH ?= ""

cmake_do_configure() {
  if [ ${OECMAKE_BUILDPATH} ]
  then
    mkdir ${OECMAKE_BUILDPATH}
    cd ${OECMAKE_BUILDPATH}
  fi

  cmake ${OECMAKE_SOURCEPATH} \
    -DCMAKE_INSTALL_PREFIX:PATH=${prefix} \
    -DCMAKE_FIND_ROOT_PATH=${STAGING_DIR_HOST} \
    ${EXTRA_OECMAKE} \
    -Wno-dev
}

EXPORT_FUNCTIONS do_configure
