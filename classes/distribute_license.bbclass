# distribute-license.bbclass will search the sources of a package to
# a given depth looking for a match to the specified pattern and if
# found will copy the matching file(s) to the deploy directory.
#
# This class is used to collect license files such as COPYING or
# LICENSE where they are found and save them per package.
#
# This package uses the following variables to control its operations:
#   - LICENSE_FILES         = Pattern of license files to be searched for.
#                             By default this is COPYING* and LICENSE* but
#                             this can be changed per package.
#   - LICENSE_SEARCH_DEPTH  = The maximum depth to search in the package
#                             sources for files matching the LICENSE_FILES
#                             pattern.


# Files to copy for the licensing.  By default this is looking for
# files following the patters COPYING* or LICENSING* in the top
# level sources directory.
LICENSE_FILES ?= "COPYING* LICENSE*"

# Maximum depth to look for license files
LICENSE_SEARCH_DEPTH ?= "1"

distribute_license_do_copy_license() {
    # Turn off globbing so that wildcards are not expanded in for loop
    set -f

    # Check if LICENSE_FILES exist.  If so copy them to DEPLOY_DIR
    # Keep the relative path of licenses the same in the DEPLOY_DIR
    for lic in ${LICENSE_FILES}
    do
        find ${S} -maxdepth ${LICENSE_SEARCH_DEPTH} -name "$lic" | \
            while read f
            do
                bn=$(basename $f)
                bd=$(dirname $f | sed -e "s|${S}||")
                install -D $f ${DEPLOY_DIR}/licenses/${PN}/$bd/$bn
            done
    done

    # Turn globbing back on
    set +f
}

EXPORT_FUNCTIONS do_copy_license

# Put after do_patch in case a patch adds the license files
do_copy_license[deptask] = "do_patch"

addtask copy_license after do_patch before do_configure
