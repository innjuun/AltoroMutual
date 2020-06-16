function XSS_Check(strTemp, level) {
  if (level === undefined || level === 0) {
    strTemp = strTemp.replace(/\<|\>|\"|\'|\%|\;|\(|)|\&|\+|\-/g, "");
  } else if (level === undefined && level === 1) {
    strTemp = strTemp.replace(/\</g, "&lt;");
    strTemp = strTemp.replace(/\>/g, "&gt;");
  }
  return strTemp;
}
