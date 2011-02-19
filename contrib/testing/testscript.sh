# this script can be used for testing purposes.
# see also http://wiki.openembedded.net/index.php/TestingScript

# you can set your machine/distro/recipe/branch in the environment
# or use these defaults
[ -n "${MACHINE}" ] || MACHINE="beagleboard"
[ -n "${DISTRO}" ] || DISTRO="minimal"
[ -n "${TARGET_RECIPE}" ] || TARGET_RECIPE="console-image"
[ -n "${TESTING_BRANCH}" ] || TESTING_BRANCH="testing-next"

# test if we have an openembedded dir, clone it if it does not exist
if [ ! -d openembedded ]
then
    (git clone git://git.openembedded.org/openembedded)
else
    # fetch latest objects and refs
    (cd openembedded; git fetch)
fi

# create local testing branch if it does not exist yet
(cd openembedded; git branch --set-upstream ${TESTING_BRANCH} origin/${TESTING_BRANCH})

# switch to the testing branch
(cd openembedded; git checkout ${TESTING_BRANCH})

[ -n "${DEFAULT_BB_MIN_VERSION}" ] || DEFAULT_BB_MIN_VERSION="1.10.2"
[ -n "${OE_SANITY}" ] || OE_SANITY="openembedded/conf/sanity.conf"
# get the current Bitbake minimum version from sanity.conf
[ -n "${BB_MIN_VERSION}" ] || BB_MIN_VERSION=`grep BB_MIN_VERSION $OE_SANITY 2>nul| sed -e 's|.*\"\(.*\)\"|\1|'`
[ -n "${BB_MIN_VERSION}" ] || BB_MIN_VERSION=$DEFAULT_BB_MIN_VERSION

# test if bitbake exist; if not; fetch it and untar it
if [ ! -d bitbake-${BB_MIN_VERSION} ]
then
    (wget http://download.berlios.de/bitbake/bitbake-${BB_MIN_VERSION}.tar.gz; tar xf bitbake-${BB_MIN_VERSION}.tar.gz; rm bitbake-${BB_MIN_VERSION}.tar.gz) 
fi

# TOPDIR is where we are now
TOPDIR=`pwd`

# add bitbake to the path
export PATH=${TOPDIR}/bitbake-${BB_MIN_VERSION}/bin:$PATH

# create a local.conf by using a here document
cat > ${TOPDIR}/openembedded/conf/local.conf << EOF
# fix next line if you want to use your own mirror, then remove the # for the next two lines
# You can start a trivial server with 'python -m SimpleHTTPServer'
#SOURCE_MIRROR_URL = "http://localhost:8000/directory"
#INHERIT += "own-mirrors"

DL_DIR = "${TOPDIR}/downloads"

# if you want to keep tmp dirs for different builds you might want to set TMPDIR to e.g. ${TOPDIR}/tmp_${MACHINE}_${DISTRO}
TMPDIR = "${TOPDIR}/tmp"
BBFILES = "${TOPDIR}/openembedded/recipes/*/*.bb"
ENABLE_BINARY_LOCALE_GENERATION = "0"

# ccache always overfill $HOME....
CCACHE=""

# What kind of images do we want?
IMAGE_FSTYPES = "tar.gz "

# Make use of my SMP box
PARALLEL_MAKE="-j4"
BB_NUMBER_THREADS = "2"

OE_STRICT_CHECKSUMS = "1"

# if you are low on disk space you can remove the next #, disadvantage, nastier debugging in case of failures
#INHERIT += "rm_work"

# if you want to report build results (recommended) you need to edit OESTATS_BUILDER and add your name or nick in it, then uncomment the next 3 lines.
#INHERIT += "oestats-client"
#OESTATS_SERVER = "tinderbox.openembedded.org"
#OESTATS_BUILDER = "your nick goes here"

EOF

# smake sure BB_ENV_EXTRAWHIT is correct, and export the needed vars
BB_ENV_EXTRAWHITE="MACHINE DISTRO TOPDIR"
export BB_ENV_EXTRAWHITE MACHINE DISTRO TOPDIR
export BBPATH=${TOPDIR}/openembedded

# pull the current branch; in case a stale lock exists remove it
(cd openembedded; rm -f .git/index.lock;git pull)

# clean tmp; I want to start with a clean build; if you changed TMPDIR in the conf file better change it here too.
rm -rf ${TOPDIR}/tmp

# add an echo about the vars so we can see what has been done in a log file
echo ${MACHINE} ${DISTRO} ${TARGET_RECIPE} ${TESTING_BRANCH} `(cd openembedded;git --no-pager log --max-count=1 --pretty=format:%H)`

# and do the actual work.
bitbake ${TARGET_RECIPE}

