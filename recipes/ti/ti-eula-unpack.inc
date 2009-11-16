# This file defines function used for unpacking the .bin file downloaded over
# the http and display EULA.
#  BINFILE - name of the install jammer .bin file
#  TARFILE - name of the tar file inside the install jammer
#  TI_BIN_UNPK_CMDS   - contains list of commands separated with colon to be 
#                       passed while unpacking the bin file. The keyword 
#                       workdir expands to WORKDIR and commands are appendded
#                       with '\n'. Eg. TI_BIN_UNPK_CMDS="Y:Y: qY:workdir"
#  TI_BIN_UNPK_WDEXT  - This variable extends workdir path, if user wants to put
#                       the output in some internal directory

python do_unpack () {
    bb.build.exec_func('base_do_unpack', d)
    bb.build.exec_func('ti_bin_do_unpack', d)
}

TI_BIN_UNPK_WDEXT += ""
python ti_bin_do_unpack() {

    import os

    localdata = bb.data.createCopy(d)
    bb.data.update_data(localdata)

    binfile  = bb.data.getVar('BINFILE', localdata)
    binfile  = bb.data.expand(binfile, localdata)

    # Change to the working directory
    save_cwd = os.getcwd()
    workdir  = bb.data.getVar('WORKDIR', localdata)
    workdir  = bb.data.expand(workdir, localdata)
    os.chdir(workdir)

    # Get unpack commands
    cmd_string = bb.data.getVar('TI_BIN_UNPK_CMDS', localdata)
    cmd_list = cmd_string.split( ":" )

    # Make the InstallJammer binary executable so we can run it
    os.chmod(binfile, 0755)

    # Run the InstallJammer binary and accept the EULA
    filename = "HOME=%s ./%s" % (workdir, binfile)
    f = os.popen(filename,'w')
    for cmd in cmd_list:
        if cmd == "workdir":
            wdext = bb.data.getVar('TI_BIN_UNPK_WDEXT', localdata)
            wdext = bb.data.expand(wdext, localdata)
            cmd = workdir+wdext
        print >>f, "%s\n" % cmd
    f.close()

    # Expand the tarball that was created if required
    tarfile  = bb.data.getVar('TARFILE', localdata)    
    if bool(tarfile) == True:
        tarfile  = bb.data.expand(tarfile, localdata)
        tcmd = 'tar xz --no-same-owner -f %s -C %s' % (tarfile, workdir)
        os.system(tcmd)

    # Return to the previous directory
    os.chdir(save_cwd)
}

