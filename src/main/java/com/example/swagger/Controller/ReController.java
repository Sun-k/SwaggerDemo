package com.example.swagger.Controller;

import com.example.swagger.bean.User;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author Sunk
 * @create 2018-4-28-10:00
 **/

@Api(value = "demo",tags = {"test"},description = "Swagger2Demo")
@RestController
@RequestMapping("/Demo")
public class ReController {

    @ApiOperation(value = "接口名称测试1",notes = "接口的介绍之类")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "flag",value = "参数说明",required = true,dataType = "String",paramType="query")
    )
    @RequestMapping(value = "/flag",method = RequestMethod.GET)
    public String getUser(@RequestParam(value = "flag",required = true) String flag,
                          @RequestParam(value = "id",required = true)String id){
        return "输入参数flag："+flag+",id:"+id;
    }


    @ApiOperation(value = "文件上传接口",notes = "处理文件上传")
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public String uploadfile(
            @RequestHeader("file") @RequestParam(value = "file",required = true)MultipartFile file){
        return "上传文件名称："+file.getOriginalFilename();
    }


    @ApiOperation(value = "批量处理文件上传接口",notes = "批量处理")
    @RequestMapping(value = "/files",method = RequestMethod.POST)
    public String uploadfiles(
            @RequestHeader("file1") @RequestParam(value = "file1",required = true)MultipartFile file1,
            @RequestHeader("file2") @RequestParam(value = "file2",required = true)MultipartFile file2){

        return "上传文件，名称分别是："+file1.getOriginalFilename()+";"+file2.getOriginalFilename();
    }

    @ApiOperation(value = "接收json格式参数（对象）",notes = "json格式的数据；或者传入对象")
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public String jsonData(
            @RequestBody @ApiParam(name="流程对象",value="传入json格式",required=true) User user){

        return "上传数据：编号为"+user.getId()+";用户名称为："+user.getName()+";年龄"+user.getAge();

    }

    @RequestMapping(value = "test")
    public String test(){
                return "Hello !";
    }





}
