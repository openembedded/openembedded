#
# Populated ${STAGING} using packages
#
# To use it add that line to conf/local.conf:
#
# INHERIT += "packaged-staging"
#

do_pstage () {
#do our magic here 
}

addtask pstage before do_build
addtask pstage after do_package
