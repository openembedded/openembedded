inherit distutils

DEPENDS += "python-setuptools"

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --single-version-externally-managed \
    --prefix=${prefix} \
    --install-data=${datadir}"
