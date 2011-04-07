#!/bin/sh

# PATH to tmpdir
TMPDIR=tmp

if [ $# -lt 1 ] ; then
  echo "Usage: $0 path/to/recipe.bb"
  exit 1
fi

if [ $# -eq 2 ] ; then
  TMPDIR=$2
fi

if [ ! -d ${TMPDIR} ] ; then
  echo "TMPDIR '${TMPDIR}' does not exist, update TMPDIR in script or use 2nd parameter"
  exit 2
fi

RECIPE=$1

if grep PACKAGES_DYNAMIC ${RECIPE} >/dev/null; then
  echo "${RECIPE} already has PACKAGES_DYNAMIC defined, please remove it first"
  exit 3
fi

# force old behavior spliting all
echo 'PACKAGES_DYNAMIC = "gst-plugin-*"' >> ${RECIPE}

echo "Cleaning ${RECIPE}"
# don't know better way to get right WORKDIR from shell, we need to clean it anyways
WORKDIR=`bitbake -c clean -v -b ${RECIPE} | grep "NOTE: removing work" | sed 's/NOTE: removing //g'`

TMPDIR_PKGS=${TMPDIR}/${WORKDIR}/packages-split/
echo "Packages are expected in ${TMPDIR_PKGS}"

echo "Building ${RECIPE}"
# -c build because some people use rm_work
bitbake -c build -b ${RECIPE}

if [ $? -ne 0 ] ; then
  echo "${RECIPE} build failed, fix build first"
  sed -i '/^PACKAGES_DYNAMIC = "gst-plugin-\*"$/d' ${RECIPE}
  exit 4
fi


if ls -1d ${TMPDIR_PKGS}/gst-plugin-*-dev | grep gst-plugin-.*-dev >/dev/null; then
  # replace temporary PACKAGES_DYNAMIC spliting all with list of created packages
  sed -i '/^PACKAGES_DYNAMIC = "gst-plugin-\*"$/d' ${RECIPE}
  echo '' >> ${RECIPE}
  echo 'PACKAGES_DYNAMIC = "\' >> ${RECIPE}
  ls -1d ${TMPDIR_PKGS}/gst-plugin-*-dev | grep gst-plugin-.*-dev| sed "s#${TMPDIR_PKGS}/\(.*\)-dev#\1* \\\#g" >> ${RECIPE}
  echo '"' >> ${RECIPE}
  echo "${RECIPE} PACKAGES_DYNAMIC were hopefully updated"
else
  echo "No directories found ${TMPDIR_PKGS}/gst-plugin-*-dev"
  exit 5
fi

