//
// Created by admin on 2019/8/9.
//

#include "BackspaceStringCompare.h"


int main()
{
    Solution s;
    s.backspaceCompare();
    std::string str = "ab#c";
    for (char& c : str) {
        std::cout << c << " " << std::endl;
    }



    for (string::size_type i = 0; i < str.length(); i++)
    {
        str[i] = toupper (str[i]);
    }

    for (decltype(str.size()) index =0; index != str.size() && !isspace(str[index]); ++index) {
        std::cout << str[index] << " " << std::endl;
    }
}