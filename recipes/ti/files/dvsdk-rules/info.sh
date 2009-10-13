#!/bin/sh

echo "Listing information about the DVSDK components:"
echo

if [ ! -e $XDC_INSTALL_DIR ]
then
    echo "Fatal!: XDC tools not found in $XDC_INSTALL_DIR, check Rules.make.."
    echo "Aborting!"
    exit
fi

for x in $REPOSITORIES
do
    echo "*******************************************************************************"
    echo "Listing package information for repository:"
    echo $x
    echo
    XDC_PATH="$XDC_INSTALL_DIR" $XDC_INSTALL_DIR/xs xdc.tools.path -Pr $x
done

echo "*******************************************************************************"
if [ -e $LINUXKERNEL_INSTALL_DIR ]
then
    echo "Using Linux kernel from:"
    echo $LINUXKERNEL_INSTALL_DIR
else
    echo "WARNING: Linux kernel not found:"
    echo $LINUXKERNEL_INSTALL_DIR
fi
echo

echo "*******************************************************************************"
echo "TI c6x codegen tool version:"
echo $CODEGEN_INSTALL_DIR/bin/cl6x
echo
if [ -f $CODEGEN_INSTALL_DIR/bin/cl6x ]
then
    $CODEGEN_INSTALL_DIR/bin/cl6x -version
else
    echo "WARNING: TI codegen not found!"
    echo
fi

echo
echo "*******************************************************************************"
echo "GCC compiler version:"
echo "$GCC_PREFIX"gcc
echo
if [ -f "$GCC_PREFIX"gcc ]
then
    "$GCC_PREFIX"gcc --version
else
    echo "WARNING: gcc tool chain not found!"
    echo
fi

echo
