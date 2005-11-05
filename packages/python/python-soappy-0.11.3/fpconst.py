"""Utilities for handling IEEE 754 floating point special values

This python module implements constants and functions for working with
IEEE754 double-precision special values.  It provides constants for
Not-a-Number (NaN), Positive Infinity (PosInf), and Negative Infinity
(NegInf), as well as functions to test for these values.

The code is implemented in pure python by taking advantage of the
'struct' standard module. Care has been taken to generate proper
results on both big-endian and little-endian machines. Some efficiency
could be gained by translating the core routines into C.

See <http://babbage.cs.qc.edu/courses/cs341/IEEE-754references.html>
for reference material on the IEEE 754 floating point standard.

Further information on this package is available at
<http://software.biostat.washington.edu/statsoft/snake/fpconst>.

Author:    Gregory R. Warnes <gregory_r_warnes@groton.pfizer.com>
Date::     2003-04-08
Copyright: (c) 2003, Pfizer, Inc.
"""

__version__ = "0.6.0"
ident = "$Id: fpconst.py,v 1.8 2003/05/12 15:14:00 warnes Exp $"

import struct

# check endianess
_big_endian = struct.pack('i',1)[0] != '\x01'

# and define appropriate constants
if(_big_endian): 
    _HW = 0
    _LW = 1
    
    NaN = struct.unpack('d', '\x7F\xFF\xFF\xFF\xFF\xFF\xFF\xFF')[0]
    PosInf = struct.unpack('d', '\x7F\xF0\x00\x00\x00\x00\x00\x00')[0]
    NegInf = -PosInf
    
else:
    _HW = 1
    _LW = 0

    NaN = struct.unpack('d', '\x00\x00\x00\x00\x00\x00\xf8\xff')[0]
    PosInf = struct.unpack('d', '\x00\x00\x00\x00\x00\x00\xf0\x7f')[0]
    NegInf = -PosInf

def _double_as_longs(dval):
    "Use struct.unpack to decode a double precision float into two longs"
    tmp = struct.unpack('ll',struct.pack('d', dval))
    return (tmp[_HW], tmp[_LW])


##
## Functions to extract components of the IEEE 754 floating point format
##

def _sign(dval):
    "Extract the sign bit from a double-precision floating point value"
    ll = _double_as_longs(dval)
    return ll[0] >> 31 & 0x01 

def _exponent(dval):
    """Extract the exponentent bits from a double-precision floating
    point value.

    Note that for normalized values, the exponentdent bits have an offset
    of 1023. As a consequence, the actual exponentent is obtained
    by subtracting 1023 for the value returned by this function
    """
    ll = _double_as_longs(dval)
    return (ll[0] >> 20) & 0x7ff

def _mantissa(dval):
    """Extract the _mantissa bits from a double-precision floating
    point value."""

    ll = _double_as_longs(dval)
    mantissa0 = (ll[0] & 0x000fffffL) << 32
    mantissa1 = ll[1] 
    return mantissa0 + mantissa1

##
## Functions to test for IEEE 754 special values
##

def isNaN(value):
    "Determine if the argument is a IEEE 754 NaN (Not a Number) value."
    return (_exponent(value)==0x7ff and _mantissa(value)!=0) 

def isInf(value):
    """Determine if the argument is an infinite IEEE 754 value (positive
    or negative inifinity)"""
    return (_exponent(value)==0x7ff and _mantissa(value)== 0)

def isFinite(value):
    """Determine if the argument is an finite IEEE 754 value (i.e., is
    not NaN, positive or negative inifinity)"""
    return (_exponent(value)!=0x7ff)


def isPosInf(value):
    "Determine if the argument is a IEEE 754 positive infinity value"
    return (_sign(value)==0 and _exponent(value)==0x7ff and \
            _mantissa(value)== 0) 

def isNegInf(value):
    "Determine if the argument is a IEEE 754 negative infinity value"
    return (_sign(value)==1 and _exponent(value)==0x7ff and \
            _mantissa(value)== 0) 
