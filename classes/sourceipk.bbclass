# sourceipk.bbclass enables the creation of an ipk file that contains the
# sources used during the build.  The sources contained in the ipk are the
# patched sources before configuration has been done.
#
# This class is used to provide an easy method to ship the corresponding
# sources for a package to end users so that they can install them on their
# host or target systems.
#
# This package uses the following variables to control its operations:
#   - CREATE_SRCIPK         = When set to 1 this variable indicates that 
#                             a source ipk should be generated for the package.
#   - SRCIPK_INSTALL_DIR    = This variable indicates the directory to install
#                             the sources into.
#   - SRCIPK_PACKAGE_ARCH   = This variable allows specific recipies to
#                             specify an architecture for the sourcetree
#                             package is "all" is not appropriate
#   - SRCIPK_INC_EXTRAFILES = When set to 1 this variable indicates that
#                             the source ipk should contain extra files
#                             such as the README file and recipe.
#
# The default installation directory for the sources is:
#   /usr/src/${PN}-src
#
# By setting the SRCIPK_INSTALL_DIR this default can be changed to any
# location desired.  When combined with the opkg -o option this allows for the
# system building to specify a relative package install location to the
# install root given to opkg.  Each source ipk can have a different directory.
# 
# Creation of the source ipk can be controlled per package by setting
# CREATE_SRCIPK = "1" in the package recipe or by setting
# CREATE_SRCIPK_pn-<package name> = "1" in your local.conf
#
#TODO: 
# Need to figure out how to use opkg-build in this class.
# I tried adding it as a dependency for the do_create_srcipk
# task using:
#   do_create_srcipk[depends] += "opkg-utils-native:do_populate_sysroot"
# But then there is a circular dependency between sourcipk.bbclass and
# opkg-utils-native.  Until I can figure out how to resolve this
# circular dependency I am extracting the needed pieces from opkg-build
# into this class and building the source ipk myself.


# Default is to not create the source ipk
CREATE_SRCIPK ?= "0"

# Default installation prefix
SRCIPK_INSTALL_DIR ?= "/usr/src/${PN}-src"

# Default PACKAGE_ARCH for sources is "all"
SRCIPK_PACKAGE_ARCH ?= "all"

# Default section matches the recipe section
SRCIPK_SECTION ?= "${SECTION}"

# Default SRCIPK_INCLUDE_EXTRAFILES is to include the extra files
SRCIPK_INCLUDE_EXTRAFILES ?= "1"

# Create a README file that describes the contents of the source ipk
sourceipk_create_readme() {
    readme="$1/README.${PN}-src"
    touch $readme
    echo 'This package contains the patched sources for ${PN} that' >> $readme
    echo 'were used to generate the ${PN} binary ipk package(s).' >> $readme
    echo 'This package does not build or generate the binaries' >> $readme
    echo 'directly.  To build the binaries you must either' >> $readme
    echo 'configure and build the sources yourself or use:' >> $readme
    echo '    bitbake ${PN}' >> $readme
    echo '' >> $readme
    echo 'NOTE: The patches applied to the sources can be found in' >> $readme
    echo "      the \"patches\" directory" >> $readme
}

# Create the source ipk file.  The ipk is manually created here instead
# of using the normal ipk system because some recipes will over write
# the PACKAGES variable.  Thus if this class added a -src package
# to the list of packages to be created that package would be lost.
# See the linux kernel recipe for an example of this issue.
sourceipk_do_create_srcipk() {
    if [ ${CREATE_SRCIPK} != "0" ]
    then
        tmp_dir="${WORKDIR}/sourceipk-tmp"
        srcipk_dir="${WORKDIR}/sourceipk-data"
        mkdir -p $tmp_dir/CONTROL
        mkdir -p $srcipk_dir
        control_file="$tmp_dir/CONTROL/control"

        # Write the control file
        echo "Package: ${PN}-src" > $control_file
        echo "Version: ${PV}-${PR}" >> $control_file
        echo "Description: Patched sources for ${PN}" >> $control_file
        echo "Section: ${SRCIPK_SECTION}" >> $control_file
        echo "Priority: Optional" >> $control_file
        echo "Maintainer: ${MAINTAINER}" >> $control_file
        echo "License: ${LICENSE}" >> $control_file
        echo "Architecture: ${SRCIPK_PACKAGE_ARCH}" >> $control_file
        srcuri="${SRC_URI}"
        if [ "$srcuri" = "" ]
        then
            srcuri="OpenEmbedded"
        fi
        echo "Source: $srcuri" >> $control_file
        #Write the control tarball
        tar -C $tmp_dir/CONTROL --owner=0 --group=0 -czf $srcipk_dir/control.tar.gz .

        # Get rid of temporary control file
        rm -rf $tmp_dir/CONTROL

        # Copy sources for packaging
        mkdir -p $tmp_dir/${SRCIPK_INSTALL_DIR}
        if [ -e ${S} ]; then
	    if [ "${S}" = "${WORKDIR}" ]; then
		excludes='--exclude ./temp/\* --exclude ./sourceipk-tmp/\* --exclude ./sourceipk-data/\*'
	    fi
            tar -C ${S} -cO $excludes . | tar -C $tmp_dir/${SRCIPK_INSTALL_DIR} -xpf -
        fi

        if [ ${SRCIPK_INCLUDE_EXTRAFILES} != "0" ]
        then
            sourceipk_create_readme $tmp_dir/${SRCIPK_INSTALL_DIR}/
            cp ${FILE} $tmp_dir/${SRCIPK_INSTALL_DIR}/
        fi

        #Write the data tarball
        tar -C $tmp_dir --owner=0 --group=0 -czf $srcipk_dir/data.tar.gz .

        # Create the debian-binary file
        echo "2.0" > $srcipk_dir/debian-binary

        #Write the ipk file
        mkdir -p ${DEPLOY_DIR_IPK}/${SRCIPK_PACKAGE_ARCH}
        pkg_file=${DEPLOY_DIR_IPK}/${SRCIPK_PACKAGE_ARCH}/${PN}-src_${PV}-${PR}_${SRCIPK_PACKAGE_ARCH}.ipk
        rm -f $pkg_file
        ( cd $srcipk_dir && ar -crf $pkg_file ./debian-binary ./data.tar.gz ./control.tar.gz )

        # Remove the temporary directory
        rm -rf $tmp_dir
    fi
}

EXPORT_FUNCTIONS do_create_srcipk

do_create_srcipk[deptask] = "do_patch"

addtask create_srcipk after do_patch before do_configure

python () {
    if d.getVar('do_compileconfigs', False):
	deps = d.getVarFlag('do_compileconfigs', 'deps') or []
	deps.append('do_create_srcipk')
	d.setVarFlag('do_compileconfigs', 'deps', deps)
}

#Add source packages to list of packages OE knows about
PACKAGES_DYNAMIC += "${PN}-src"
