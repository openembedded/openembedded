DESCRIPTION = "The Python Programming Language"
HOMEPAGE = "http://www.python.org"
LICENSE = "PSF"
SECTION = "devel/python"
PRIORITY = "optional"
# bump this on every change in contrib/python/generate-manifest-2.7.py
INC_PR = "ml1"

DEFAULT_PREFERENCE = "-27"

PYTHON_MAJMIN = "2.7"

inherit autotools

EXTRA_OECONF = "\
  --with-threads \
  --with-pymalloc \
  --with-cyclic-gc \
  --without-cxx \
  --with-signal-module \
  --with-wctype-functions \
  --enable-shared \
"
