package com.ahau.controller.bamboo.base;

import com.ahau.entity.bamboo.base.Result;
import com.ahau.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Elasticsearch")
@Api(description = "搜索引擎")
public class SearchController {

    private static final Logger LOGGER = LogManager.getLogger(SearchController.class);

    private final TransportClient client;

    @Autowired
    public SearchController(TransportClient client) {
        this.client = client;
    }


    /**
     * 查询所有种列表
     *
     * @return
     */
    @ApiOperation(value = "查找所有种列表", notes = "查找所有种列表")
    @GetMapping("search")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keywords", value = "查询关键字", paramType = "query"),
    })
    public Result search(String keywords) {
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("bambootattan");



        if (StringUtils.isEmpty(keywords)) {
            searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());
        } else {

            searchRequestBuilder.setQuery(QueryBuilders.queryStringQuery(keywords));
            searchRequestBuilder.setFrom(0);
            searchRequestBuilder.setSize(10);
            searchRequestBuilder.setExplain(true);
        }
        SearchResponse response = searchRequestBuilder.execute().actionGet();

        SearchHits hits = response.getHits(); //获得hits数组
        List<Map<String, Object>> list =new ArrayList<Map<String, Object>>();
        long totalHits = hits.getTotalHits(); //获取检索的文档总数（不是这次返回的数量）
        for (SearchHit hit : hits) {
            String index = hit.getIndex(); //获取文档的index
            String type = hit.getType(); //获取文档的type
            String id = hit.getId(); //获取文档的id
            Map<String, Object> sourceMap = hit.getSourceAsMap(); //获取文档内容，封装为map
            String sourceString = hit.getSourceAsString(); //获取文档内容，转换为json字符串。
            list.add(sourceMap);
        }
        return ResultUtil.success(list);

    }


}
